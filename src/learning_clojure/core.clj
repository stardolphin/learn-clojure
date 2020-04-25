(ns learning-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "I can't even!")
(assoc {:a 1 :b 2} :c 3 :d 4)
(assoc-in {:settings {:a 1 :b 2}} [:settings :a] 'eh?')
(def s #{1, 2, 3, 4})
(conj s 5)
(disj s 2 3)
(defn my-sum5 [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))
    )
)

(my-sum5 0 [0 1 2 3 4])

(defn my-sum4
 ([vals] (my-sum 0 vals))
 ([total vals] 
  (if (empty? vals)
    total
    (my-sum4 (+ (first vals) total) (rest vals)))))

(my-sum4 [0 1 2 3 4])

(defn my-sum3
 ([vals] (my-sum3 0 vals))
 ([total vals] 
  (if (empty? vals)
    total
    (recur (+ (first vals) total) (rest vals)))))

(my-sum3 [0 1 2 3 4 5])


(defn my-sum2 [vals]
(loop [total 0 vals vals]
(if (empty? vals)
  total
  (recur (+ (first vals) total) (rest vals)))))

(my-sum2 [0 1 2 3 4 5 6])


