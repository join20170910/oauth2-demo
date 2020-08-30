import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName DemoTest
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 14:28
 * @Version 1.0
 **/
public class DemoTest {

    @Test
    public void test01(){
        Flux.just("Hello","World").subscribe( System.out::println );

        Flux.fromArray(new Integer[]{1,2,3}) .subscribe(System.out::println);

        System.out.println("----------------");

        Flux.empty().subscribe(System.out::println);
        System.out.println("----------------");
        Flux.range(1,5).subscribe(System.out::println);
        System.out.println("----------------");

    }

    @Test
    public void test02(){

        Flux.generate(
                sink ->{
                    sink.next("Hello");
                    sink.complete();
                }
        ).subscribe(System.out::println);
    }


    @Test
    public void test03(){

        Flux.create(
                sink ->{
                    for(int i = 0; i < 10; i++) {
                        sink.next(i);
                    }
                    sink.complete();
                }
        ).subscribe(System.out::println);
    }

    @Test
    public void test04(){

        Flux.create(
                sink ->{
                    for(int i = 0; i < 10; i++) {
                        sink.next(i);
                    }
                    sink.complete();
                }
        ).subscribe(System.out::println);
    }

    @Test
    public void test06(){

        Flux.range(1,5)
                .flatMap(
                        x -> Mono.just(x * x)
                ).subscribe(System.out::println);
        System.out.println("--------------------");
     Flux.range(1,5)
             .map(
            x -> (x + x)
            ).subscribe(System.out::println);

        System.out.println("--------------------");
        Flux.range(1,10).filter(
                 i -> i %2 == 0
        ).subscribe(System.out:: println);
}
}
