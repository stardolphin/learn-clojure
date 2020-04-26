(ns learn_clojure.ludicrous
  (:require [clojure.test :refer :all])
  (:import (java.util UUID)))

(defn uuid [] (str (UUID/randomUUID)))

(defn sum [items] (reduce + items))

;; should this be (map :contents) ??
(defn container-space [{container-size :size contents :contents}]
  (- container-size (sum (map :size))))


(defn container-with-space [bin container]
    (> (container-space container) :size))

(defn select-container [containers bin]
  (first (filter (partial container-with-space bin) (vals containers))))


(defn pack-bin [containers bin]
  (let [selected-container (select-container containers bin)]
    (when selected-container
      update-in containers [(:id selected-container) :contents]
      conj bin)))

(def containers (let [id (uuid)] {:size 1000 :contents [] :id id}))

(def bin {:size 23 :id (uuid)})

(container-with-space bin (first containers))

(select-container containers bin)

;; (pack-bin containers bin)


;; the partial takes a partially set up function, bin already, so only
;; the 'container' argument varies. Put the variant argument last!
;; Clojure REPL and TDD Feedback at the speed of light: 16:00 in.
;; https://www.youtube.com/watch?v=mSRxiYNk3bY&t=26s 4:29 learning cider
