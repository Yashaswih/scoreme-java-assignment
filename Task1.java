import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccounts> accounts) {

        List<LoanAccount> result = new ArrayList<>();

        // FIX: Return empty list if input list is null
        if (accounts == null) {
            return new ArrayList<>();
        }

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        for (LoanAccount account : accounts) {

            // FIX: Check due date is not null before comparing dates
            if (account.getDueDate() != null &&
                    account.getDueDate().before(new Date())) {

                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
