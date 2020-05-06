(ns learn-clojure.proxy-and-reifying)

(def my-thread (proxy [Thread] [] (run [] (println "Running in a thread, man!"))))
(.run my-thread)

;; create a thread pool
(import 'java.util.concurrent.Executors)
(def my-pool (Executors/newFixedThreadPool 4))
(.submit my-pool my-thread)

;; interface

(def my-runnable (proxy [Runnable] [] (run [] (println "Running on empty, in a runnable"))))
(.submit my-pool my-runnable)



