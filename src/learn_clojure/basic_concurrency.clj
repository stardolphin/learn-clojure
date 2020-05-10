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
(defn my-slow-function []
  (let [p (promise)]
    (.start (Thread. ^Runnable (fn [] (Thread/sleep 5000)
                                 (deliver p "HI THERE!"))))
    p
    ))

;; this function does not block
(my-slow-function)

;; deref causes promise to block for 5 seconds
(deref (my-slow-function))





