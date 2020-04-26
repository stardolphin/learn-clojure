


(ns learn-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; multi-variate recursive example
(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals] 
   (if (empty? vals)
     total
     (recur (+ (first vals) total) (rest vals)))))

(my-sum [1 2 3 4 5])

(defn thing "Pink moon!" [] (println "PINK!")
  )
(thing)

(reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4] )
(reduce (fn [total vals] (* total vals)) 1 [1 2 3 4 5])

(take 15 (cycle [1 2 3 4]))

(defn my-zipmap [keys vals]
  (loop [my-map {}
         my-keys (seq keys)
         my-vals (seq vals)]
    (if (and my-keys my-vals)
      (recur (assoc my-map (first my-keys) (first my-vals))
             (next my-keys)
             (next my-vals))
      my-map)))

(println (my-zipmap [:a :b :c] [1 2 3]))

(defun my-command ()
  (interactive)
  (save-excursion)
  (do-some-things)
  (do-more-things)
  (conclude-doing-things a-string)
  )

;; 

;; http://danmidwood.com/content/2014/11/21/animated-paredit.html
;; https://www.youtube.com/watch?v=D6h5dFyyUX0   - paredit mode
;; https://youtu.be/AmP6rW30wjE - Some database access
