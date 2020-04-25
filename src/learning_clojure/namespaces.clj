(ns learnclojure.namespaces)
(require '[clojure.string :refer [split]])
(split "a,b,c" #",")

(import 'java.util.Date)
(str (Date.))
