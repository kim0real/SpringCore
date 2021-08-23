package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        //AppConfig.java를 appConfig.xml로 대체할 수 있다.
        //최근에는 xml을 잘 사용하지 않으나 사용중인 곳도 있으니 알아두자.
        ApplicationContext aC = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = aC.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
