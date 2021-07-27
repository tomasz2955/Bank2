import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import com.company.Account;
import com.company.AccountRepository;
import com.company.AccountStatisticsService;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

public class AccountStatisticsServiceTest {

    private AccountRepository accountRepository;
    private AccountStatisticsService statisticsService;

   @Before
   public void beforeTests() {
       accountRepository = mock(AccountRepository.class);
       statisticsService = new AccountStatisticsService(accountRepository);
   }

    @Test
    public void shouldReturnSumMoney() {
        when(accountRepository.getBankAccounts())
                .thenReturn(Collections.singletonList(new Account("Piotr", 100)));
        double result = statisticsService.sumAccountMoney();
        assertEquals(result, 100, 0);
    }
}
