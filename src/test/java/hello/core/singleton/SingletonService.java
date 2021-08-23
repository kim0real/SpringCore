package hello.core.singleton;

public class SingletonService {
    //자기 자신을 외부에서 사용하지 못하도록 private
    //공유하기 위하여 static
    //JVM이 실행될 때 instance 참조를 생성한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){}


}
