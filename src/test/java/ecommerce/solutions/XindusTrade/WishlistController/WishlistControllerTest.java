package ecommerce.solutions.XindusTrade.WishlistController;

import ecommerce.solutions.XindusTrade.EcommerceController.WishlistController;
import ecommerce.solutions.XindusTrade.EcommerceEntity.Users;
import ecommerce.solutions.XindusTrade.EcommerceEntity.WishlistItems;
import ecommerce.solutions.XindusTrade.EcommerceRepository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WishlistControllerTest {

    @Autowired
    private WishlistController wishlistController;
    @Mock
    private Authentication authentication;
    @Mock
    private UserRepository userRepository;

    public void setup() {
        Mockito.when(authentication.getName()).thenReturn("abc");
    }

    @Test
    public void shouldReturnInvalidUser_whenGetWishList() throws Exception {
        //given
        Mockito.when(authentication.getName()).thenReturn("abc");
        var runtimeException = Assertions.assertThrows(RuntimeException.class, () -> wishlistController.getUserWishlist(authentication));

        //then
        Assertions.assertEquals("username is invalid, please enter the correct username", runtimeException.getMessage());
    }

    @Test
    public void shouldReturnEmptyWishlist_whenGetWishList() {
        //given
        WishlistItems wishlistItems = WishlistItems.builder().name("shirt").price(100).build();
        Users users = Users.builder().wishlistItemsList(List.of(wishlistItems)).build();
        var mockUser = Optional.of(users);
        Mockito.when(authentication.getName()).thenReturn("abc");
        Mockito.when(userRepository.findByUsername("abc")).thenReturn(mockUser);

        //when
        var response = wishlistController.getUserWishlist(authentication);

        //then
        Assertions.assertEquals(wishlistItems, response.getBody().get(0));

    }
}
