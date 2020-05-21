(ns learn-clojure.types-and-records)

(deftype MyPerson [name])

(def person-instance (MyPerson. "Calhoun"))
(println (.name person-instance))

(println (.name (->MyPerson "Haystack")))

