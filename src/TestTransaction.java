import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	@Test
	public void test1(){
		transactions.stream().filter(x -> x.getYear() == 2011)
				.sorted((t1,t2) -> Integer.compare(t1.getValue(),t2.getValue()))
				.forEach(System.out::println);
	}
	@Test
	public void test2(){
		transactions.stream().map(x -> x.getTrader().getCity()).distinct().forEach(System.out::println);
	}
	@Test
	public void test3(){
		transactions.stream().filter(x -> x.getTrader().getCity().equals("Cambridge"))
				.map(x -> x.getTrader())
				.sorted((t1,t2) -> t1.getName().compareTo(t2.getName()))
				.forEach(System.out::println);
	}
    @Test
	public void test4(){
		boolean b = transactions.stream().anyMatch(x-> x.getTrader().getCity().equals("Milan"));
		System.out.println(b);
	}
	@Test
	public void test5(){
		transactions.stream().map(x->x.getTrader().getName()).sorted((t1,t2) -> t1.compareTo(t2))
				.forEach(System.out::println);
		String s = transactions.stream().map(x->x.getTrader().getName()).sorted((t1,t2) -> t1.compareTo(t2))
				.reduce("",String::concat);
        Optional<String> reduce = transactions.stream().map(x -> x.getTrader().getCity())
                .reduce(String::concat);

//        System.out.println(s);

        System.out.println(reduce);
	}
	@Test
	public void testdevide(){
		BigDecimal a = new BigDecimal(20);
		BigDecimal divide = a.divide(new BigDecimal(3), 2, BigDecimal.ROUND_HALF_UP);
		System.out.println(divide);

	}
	@Test
	public void test6(){

	}

}