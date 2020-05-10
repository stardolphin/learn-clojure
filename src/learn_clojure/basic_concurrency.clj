(ns learn-clojure.basic-concurrency)

;; all clojure functions are runnable
(instance? Runnable (fn []))

;; Any function is easily run in a thread
(.start (Thread. ^Runnable (fn [] (println "Hello"))))

;; promise waits for delivery
(promise)

;; deliver to a promise
(deliver (promise) "Hello")

;; promises work best with delivery from separate thread
;; this function sleeps and delivers a string to the promise, 'p'
(defn my-slow-function-with-promise []
  (let [p (promise)]
    (.start (Thread. ^Runnable (fn [] (Thread/sleep 2000)
                                 (deliver p "HI THERE!"))))
    p
    ))

;; this function does not block
(my-slow-function-with-promise)

;; deref causes promise to block for 2 seconds
(deref (my-slow-function-with-promise))

;; @ is another way to 'deref'
@(my-slow-function-with-promise)

;; typical use of a promise
(let [p (my-slow-function-with-promise)] (println "Waiting for a promise ... ") @p)

;; now with a 'future', no promise ;)
(defn my-slow-function [] (Thread/sleep 2000) "Hellooooo")

;; dereference the future'd function and it will fire
@(future (my-slow-function))

;; you can use future to create a thread
(defn slow-log [msg] (Thread/sleep 2000) (println msg))
(defn calling-function [] (future (slow-log "Called calling-function")) :ok)
(calling-function)

;; delay never triggers until...
(defn my-function-with-delay [] (delay (slow-log "Delayed Message")) :ok)
(my-function-with-delay)

