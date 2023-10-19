package ecommerce.shop.domain.users.user;

import ecommerce.shop.domain.address.AddressBook;
import ecommerce.shop.domain.cart.Cart;
import ecommerce.shop.domain.point.Point;
import ecommerce.shop.domain.users.common.Account;
import ecommerce.shop.domain.users.common.UserBase;
import ecommerce.shop.domain.users.common.UserLevel;
import ecommerce.shop.domain.users.common.UserStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends UserBase {

    private String nickname;

    private String phone;

    @Embedded
    private Account account;

    private Long point;

    private LocalDateTime nicknameModifiedDate;

    private UserStatus userStatus;

    @OneToMany(mappedBy = "user")
    private List<Point> pointBreakdown = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "ADDRESSBOOK_ID")
    private AddressBook addressBook;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CART_ID")
    private Cart cart;


    @Builder
    public User(Long id, String email, String password, UserLevel userLevel, String nickname,
            String phone,
            LocalDateTime nicknameModifiedDate, AddressBook addressBook, UserStatus userStatus,
            Long point, List<Point> pointBreakdown) {
        super(id, email, password, userLevel);
        this.nickname = nickname;
        this.phone = phone;
        this.userLevel = userLevel;
        this.nicknameModifiedDate = nicknameModifiedDate;
        this.addressBook = addressBook;
        this.userStatus = userStatus;
        this.point = point;
        this.pointBreakdown = pointBreakdown;
    }

    public void createCart(Cart cart) {
        this.cart = cart;
    }

    public void createAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
