(ns learn-clojure.clojure-software-transactional-memory)

;; set up an atom with initial value of 0
(def count-atom (atom 0))
(println @count-atom)

;; run inc function into the count-atom 1000 times
(dotimes [_ 1000] (future (swap! count-atom inc)))
(println @count-atom)

;; again!
(dotimes [_ 1000] (future (swap! count-atom inc)))
(println @count-atom)

;; atom, a way to save state 'safely'
