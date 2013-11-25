(ns renoise-osc-clj.midi)

(def notes- {\c 0
             \d 2
             \e 4
             \f 5
             \g 7
             \a 9
             \b 11
             })

(def signs- {\_ -1
             \# 1
             })

(def octaves- {\1 2 \2 3 \3 4 \4 5 \5 6 \6 7 \7 8 \8 9})

(defn sym->midi
  ([input]
    (let [inn (seq (name input))
          nnil (fn [i] (some #(when (not (nil? %)) %) i))
          n (nnil (map notes- inn))
          s (nnil (map signs- inn))
          o (nnil (map octaves- inn))]
      (+ (+ (if n n 0) (if s s 0)) (* (if o o 1) 12))))
  ([inn & args] (map sym->midi (conj args inn))))
