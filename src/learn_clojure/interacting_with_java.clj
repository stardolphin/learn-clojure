(ns learn-clojure.interacting-with-java
  (:require [clojure.string :as str])
  (:import [java.util Date Calendar]))

(def date (str (Date. (System/currentTimeMillis))))

(println date)

(def millis (System/currentTimeMillis))

(println long millis)

;;
(Date. (System/currentTimeMillis))

;;
(. (Date.) getTime)

;;
(doto (Calendar/getInstance)
  (.set Calendar/YEAR 1985)
  (.set Calendar/MONTH 05)
  (.set Calendar/DATE 04))

;;
(int-array 10)

;; try ^<space> to expand commands
(str/capitalize "FoO fOf")

;;
(def my-array (into-array String ["Doctor" "my" "eyes"]))
(aget my-array 0)

