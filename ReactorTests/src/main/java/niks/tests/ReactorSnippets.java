package niks.tests;

import java.time.Duration;
import java.time.temporal.*;
import java.util.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorSnippets {
	  private static List<String> words = Arrays.asList(
	        "the",
	        "quick",
	        "brown",
	        "fox",
	        "jump",
	        "over",
	        "the",
	        "lazy",
	        "dog"
	        );

	  public static void main(String args[]) {
		  ReactorSnippets rs = new ReactorSnippets();
		  //rs.simpleCreation();
		  //rs.findingMissingLetter();
		  //rs.restoringMissingLetter();
		  //rs.shortCircuit();
		  //rs.blocks();
		  rs.firstEmitting();
	  }
	  
	  public void blocks() {
		  Flux<String> helloPauseWorld = 
		    Mono.just("Hello")
		        .concatWith(Mono.just("world")
		                        .delaySubscriptionMillis(1500));

		  helloPauseWorld.toStream().forEach(System.out::println);
	  }
	  
	  public void firstEmitting() {
		  Mono<String> a = Mono.just("oops I'm late")
		                       .delaySubscriptionMillis(450);
		  Flux<String> b = Flux.just("let's get", "the party", "started")
		                       .delayMillis(400);

		  Flux.firstEmitting(a, b)
		      .toIterable()
		      .forEach(System.out::println);
	  }
	  
	  public void shortCircuit() {
	    Flux<String> helloPauseWorld = 
	                Mono.just("Hello")
	                    .concatWith(Mono.just("world")
	                    .delaySubscriptionMillis(500));
	    helloPauseWorld.subscribe(System.out::println);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  }
	  
	  
	  
	  public void restoringMissingLetter() {
		  Mono<String> missing = Mono.just("s");
		  Flux<String> allLetters = Flux
		        .fromIterable(words)
		        .flatMap(word -> Flux.fromArray(word.split("")))
		        .concatWith(missing)
		        .distinct()
		        .sort()
		        .zipWith(Flux.range(1, Integer.MAX_VALUE),
		              (string, count) -> String.format("%2d. %s", count, string));

		  allLetters.subscribe(System.out::println);
	  }
	  
	  public void findingMissingLetter() {
		  Flux<String> manyLetters = Flux
		        .fromIterable(words)
		        .flatMap(word -> Flux.fromArray(word.split("")))
		        .distinct()
		        .sort()
		        .zipWith(Flux.range(1, Integer.MAX_VALUE),
		              (string, count) -> String.format("%2d. %s", count, string));

		  manyLetters.subscribe(System.out::println);
		}
	  
	  
	  public void simpleCreation() {
	     Flux<String> fewWords = Flux.just("Hello", "World");
	     Flux<String> manyWords = Flux.fromIterable(words);
	     
	     
	     fewWords.subscribe(System.out::println);
	     //fewWords.delay(Duration.of(10, ChronoUnit.SECONDS));
	     fewWords.delaySubscription(Duration.of(10, ChronoUnit.SECONDS));
	     manyWords.parallel();
	     System.out.println();
	     manyWords.subscribe(System.out::println);
	  }
	}