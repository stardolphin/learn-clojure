(ns learn-clojure.concurrency-core-async
  (:require [clojure.core.async :refer [chan go >! <! go-loop]]))

;; chan can take a buffer, a transform, a number implying number of messages
(def my-chan (chan))

;; go named after 'golang' suck from my-chan, creates a future?
(go (println (<! my-chan)))

;; push a message down into my-chan
(go (>! my-chan "Hello"))

(go-loop []
  (println "!:" (<! my-chan))
  (recur))

;; send ns and next to repl and the go-loop will act on it
(go (>! my-chan "Hello"))


(defn print-listener [chan]
  (go-loop []
    (println (<! chan))
    (recur))
  chan)

(def new-chan (chan))
(print-listener new-chan)
