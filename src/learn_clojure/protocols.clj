(ns learn-clojure.protocols)

;; like an abstract base class?
(defprotocol Shape (area [this]) (perimeter [this]))

;; implements both the methods
(defrecord Circle [r]
  Shape
  (area [this] (* (. Math PI) (:r this) (:r this)))
  (perimeter [this] (* 2 (. Math PI) (:r this))))

;; give the area of a circle
(area (->Circle 5))
(perimeter (->Circle (* (/ 1 2) (/ 1 (. Math PI)))))

(deftype Square [s])

(extend-protocol Shape
  Square
  (area [this] (* (.s this) (.s this)))
  (perimeter [this] (* (.s this) 4)))

(println (area (->Square 8)))

;; protocols can extend existing classes
(import '[java.util Date Calendar])

(defprotocol RoundableDate (nearest-day [this]))

(extend-protocol RoundableDate
  Long
  (nearest-day [this] (- this (mod this 86400000))))




