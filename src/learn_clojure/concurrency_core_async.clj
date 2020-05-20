(ns learn-clojure.concurrency-core-async
  (:require [clojure.core.async :refer [chan go >! <! go-loop alts!]]))

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

(defn reverser [in-chan]
  (let [out-chan (chan)]
    (go-loop []
      (>! out-chan (reverse (<! in-chan))) (recur))
    out-chan))

(def in-chan (chan))
(def rev-chan (reverser in-chan))
(print-listener rev-chan)
(go (>! in-chan [1 2 3]))

(defn combine-channels [& channels]
  (let [out-chan (chan)]
    (go-loop []
      (let [[value _] (alts! channels)] (>! out-chan value))
      (recur))
    out-chan)
  )
(def chan1 (chan))
(def chan2 (chan))

(def both-channels (combine-channels chan1 chan2))

(print-listener both-channels)

(go (>! chan1 "Hi chan1!"))
(go (>! chan2 "Hi chan2!"))
