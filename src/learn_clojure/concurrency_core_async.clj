(ns learn-clojure.concurrency-core-async
  (:require [clojure.core.async :refer [chan go >! <! go-loop] ]))

;; chan can take a buffer, a transform, a number implying number of messages
(def my-chan (chan))

;; go named after 'golang' suck from my-chan, blocks
(go (println (<! my-chan)))

;; push a message down into my-chan
(go (>! my-chan "Hello"))




