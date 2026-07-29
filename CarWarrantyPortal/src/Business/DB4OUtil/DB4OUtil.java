package Business.DB4OUtil;

import Business.Ecosystem.Ecosystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;

public class DB4OUtil {

    // Saved to a predictable target folder relative to project root
    private static final String FILENAME = Paths.get("target", "Databank.db4o").toString();
    private static DB4OUtil dB4OUtil;

    // Private constructor prevents external instantiation
    private DB4OUtil() {}

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    /**
     * Fixed: Changed access modifier to public so your application can open connections.
     */
    public synchronized ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();

            // Enables automatic management of object states
            config.common().add(new TransparentPersistenceSupport());

            // Fixed: Set safe, deep thresholds instead of Integer.MAX_VALUE to prevent OOM errors
            config.common().activationDepth(10);
            config.common().updateDepth(10);

            // Cascades modifications down into your ecosystem hierarchy
            config.common().objectClass(Ecosystem.class).cascadeOnUpdate(true);
            config.common().objectClass(Ecosystem.class).cascadeOnDelete(true);

            return Db4oEmbedded.openFile(config, FILENAME);
        } catch (Exception ex) {
            throw new RuntimeException("Critical: Could not initialize db4o database connection", ex);
        }
    }

    public synchronized void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * Utility method to safely fetch or initialize your Ecosystem root.
     */
    public synchronized Ecosystem retrieveSystem(ObjectContainer conn) {
        var list = conn.query(Ecosystem.class);
        if (list.isEmpty()) {
            Ecosystem system = new Ecosystem();
            conn.store(system);
            conn.commit();
            return system;
        }
        return list.get(0);
    }

    /**
     * Utility method to save changes safely.
     */
    public synchronized void storeSystem(ObjectContainer conn, Ecosystem ecosystem) {
        conn.store(ecosystem);
        conn.commit();
    }
}

