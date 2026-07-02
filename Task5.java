import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {

                // FIX: Treat validation failure separately
                logger.warn("Document is null.");
                return null;
            }

            String content = doc.extractContent();

            if (content.isEmpty()) {

                // FIX: Treat validation failure separately
                logger.warn("Document content is empty.");
                return null;
            }

            return runValidationRules(content);

        } catch (Exception e) {

            // FIX: Replace printStackTrace with structured logging
            logger.error("Unexpected error while validating document.", e);

            // FIX: Do not silently swallow unexpected exceptions
            throw e;
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException
                if (r != null && r.isValid()) {

                    saveResult(r);

                }

            } catch (Exception e) {

                // FIX: Log unexpected exceptions instead of swallowing them
                logger.error("Error while validating document in batch.", e);

            }

        }

    }

    private ValidationResult runValidationRules(String content) {
        return null;
    }

    private void saveResult(ValidationResult result) {

    }
}