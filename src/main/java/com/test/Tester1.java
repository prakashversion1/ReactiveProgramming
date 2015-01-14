package com.test;

import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;cd 

/**
 * Created by pcjoshi on 1/7/15.
 */
public class Tester1 {

    static Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>(){
        @Override
        public void call(Subscriber<? super String> sub) {
            sub.onNext("Hello, world!");
            sub.onCompleted();
        }
    });


    static Observable<List<String>> query(String text){
        String url = "https://api.github.com/users?since=";
        List<String> answers = new ArrayList<>();
        try {
            String users = HttpConnect.httpGet(url + 5);
            JSONArray objectArray = new JSONArray(users);
            for (int i = 0; i < objectArray.length(); i++) {
                JSONObject row = objectArray.getJSONObject(i);
                answers.add(row.getString(text));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        Observable<List<String>> observable = Observable.just(answers);
        return observable;
    };


    static Observable<String> myObservable1 = Observable.just("Hello, world from observable 1");

    static Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println(s);
        }
    };



    static Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {
            System.out.println("Completed successfully");
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(String s) {
            System.out.println("Inside subscriber's on next method");
            System.out.println(s);
        }
    };

    public static void main(String[] args) {

/*
        myObservable.subscribe(mySubscriber);

        myObservable1.subscribe(onNextAction);

        Observable.just("Hello, world lambda!").subscribe(s -> System.out.println(s));

        Observable.just("Hello prakash").map(s -> s.hashCode()).map(s -> s.toString()).subscribe(s -> System.out.println(s));

        Observable.just("url1", "url2", "url3").subscribe(url -> System.out.println(url));
*/

/*
        query("sirname")
                .subscribe(names -> {
                    for (String url : names) {
                        System.out.println(url);}
                        }
                );
*/


/*
        query("name").subscribe(names ->
                Observable.from(names).subscribe(s -> System.out.println(s))
        );
*/


        query("repos_url").flatMap(new Func1<List<String>, Observable<?>>() {
            @Override
            public Observable<String> call(List<String> Names) {
                return Observable.from(Names).map(s -> {
                    int lastIndex = s.lastIndexOf("/");
                    int secondLast = s.lastIndexOf("users/")+6;
                    String name = s.substring(secondLast,lastIndex);
                    return name;
                });
            }
        }).subscribe(s -> System.out.println(s));
        System.out.println("Hey it's me async brother");

//        query("sirname").flatMap(list -> Observable.from(list)).subscribe(s -> System.out.println(s));

        }

}
