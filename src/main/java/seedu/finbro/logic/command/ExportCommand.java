package seedu.finbro.logic.command;

import seedu.finbro.model.TransactionManager;
import seedu.finbro.storage.Storage;
import seedu.finbro.ui.Ui;

/**
 * @author alanwang
 * @project tp
 * @date 9/3/25
 */

/**
 * Represents a command to export data.
 */
public class ExportCommand implements Command {
    private final String format;

    /**
     * Constructs an ExportCommand with the specified format.
     *
     * @param format The format to export data in (csv or txt)
     */
    public ExportCommand(String format) {
        this.format = format != null ? format.toLowerCase() : "csv";
    }

    /**
     * Executes the command to export data.
     *
     * @param transactionManager The transaction manager to export data from
     * @param ui                 The UI to interact with the user
     * @param storage            The storage to save data
     * @return The response message from executing the command
     */
    @Override
    public String execute(TransactionManager transactionManager, Ui ui, Storage storage) {
        String filePath;
        try {
            if ("txt".equals(format)) {
                filePath = storage.exportToTxt(transactionManager);
            } else {
                // Default to CSV
                filePath = storage.exportToCsv(transactionManager);
            }
            return "Data exported successfully to: " + filePath;
        } catch (Exception e) {
            return "Error exporting data: " + e.getMessage();
        }
    }

    /**
     * Returns false since this is not an exit command.
     *
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}