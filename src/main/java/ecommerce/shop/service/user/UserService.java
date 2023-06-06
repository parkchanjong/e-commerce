package ecommerce.shop.service.user;

import ecommerce.shop.domain.address.AddressBook;
import ecommerce.shop.domain.address.AddressBookRepository;
import ecommerce.shop.domain.cart.Cart;
import ecommerce.shop.domain.cart.CartRepository;
import ecommerce.shop.domain.users.user.User;
import ecommerce.shop.domain.users.user.UserRepository;
import ecommerce.shop.exception.user.DuplicateEmailException;
import ecommerce.shop.exception.user.DuplicateNicknameException;
import ecommerce.shop.service.encrytion.EncryptionService;
import ecommerce.shop.web.dto.UserDto.SaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final AddressBookRepository addressBookRepository;
    private final CartRepository cartRepository;

    @Transactional(readOnly = true)
    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Transactional
    public void save(SaveRequest requestDto) {
        if (checkEmailDuplicate(requestDto.getEmail())) {
            throw new DuplicateEmailException();
        }
        if (checkNicknameDuplicate(requestDto.getNickname())) {
            throw new DuplicateNicknameException();
        }
        requestDto.passwordEncryption(encryptionService);

        User user = userRepository.save(requestDto.toEntity());
        createRequiredInformation(user);
    }

    private void createRequiredInformation(User user) {
        user.createCart(cartRepository.save(new Cart()));
        user.createAddressBook(addressBookRepository.save(new AddressBook()));
    }

}
