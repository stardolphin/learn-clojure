(ns learn-clojure.types-and-records)

(deftype MyPerson [name])

(def person-instance (MyPerson. "Calhoun"))
(println (.name person-instance))

(println (.name (->MyPerson "Haystack")))

(defrecord MyPersonRecord [name])

;; #learning_clojure.core.MyPersonRecord{:name "Jordan"}
(->MyPersonRecord "Jordan")

;; Treat these as a map
(println (:name (->MyPersonRecord "Jordan")))

;; Possible to create a map directly from one of these
(println (:name (map->MyPersonRecord {:name "Freddy"})))

(deftype MyRunnable [name]
  Runnable
  (run [this] (println (.name this))))

;; Not sure, but defines a runnable in Java
(.run (MyRunnable. "Francine"))

