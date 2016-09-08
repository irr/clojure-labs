(ns async.core
  (:require [clojure.core.async :refer :all])
  (:gen-class))

(defn -main [& args]
  (println "routines...")

  (doseq [i (range 10)]
    (go
      (Thread/sleep (rand-int 1000))
      (println i)))

  (Thread/sleep 2000)

  (println "channels...")

  (let [c (chan)]
      (doseq [i (range 10)]
        (go
          (Thread/sleep (rand-int 1000))
          (>! c i)))

      (<!!
        (go
          (doseq [_ (range 10)]
            (println (<! c))))))

  (println "channels (timeout)...")

  (let [c (chan)]
    (go
      (Thread/sleep (rand-int 1000))
      (>! c "success!"))

    (<!!
      (go
        (let [[result source] (alts! [c (timeout 500)])]
          (if (= source c)
            (println "Got a value!")
            (println "Timeout!")))))))
