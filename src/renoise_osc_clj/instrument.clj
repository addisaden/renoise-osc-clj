(ns renoise-osc-clj.instrument
  (:use renoise-osc-clj.messages)
  (:use overtone.osc))

(defn create-instrument
  [renoise-client instrument-id track-id]
  {:note     (note-on renoise-client instrument-id track-id)
   :note-off (note-off renoise-client instrument-id track-id)
   })
