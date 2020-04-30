(ns learn-clojure.interacting-with-java
  (:import [java.util Date Calendar]))

(def date (str (Date. (System/currentTimeMillis))))

(def millis (System/currentTimeMillis))

(println long millis)

(Date. (System/currentTimeMillis))




