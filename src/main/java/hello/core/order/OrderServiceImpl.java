package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인 정책을 변경하기 위해서는 위를 주석처리하고 이렇게 바꿔야한다.
    //final 키워드를 넣을 시 아래에서 바로 초기화하지 않으면 생성자에서만 초기화 할 수 있다.(때문에 생성자 주입방식에서만 final을 사용할 수 있는 것)
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    //@RequiredArgsConstuctor로 대체가능 : final 필드에 대해 자동으로 생성자를 만들어줌
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
