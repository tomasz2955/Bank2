import com.company.*;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
    private static final AccountRepository accountRepository = new AccountRepository();
    private static final AccountStatisticsService accountStatisticsService = new AccountStatisticsService(accountRepository);
    private static final AccountService accountService = new AccountService(accountRepository);
    private static final AccountIdentityService accountIdentityService = new AccountIdentityService(accountRepository);
    private Account account;

}
