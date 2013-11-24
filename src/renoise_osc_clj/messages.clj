(ns renoise-osc-clj.messages
  (:use overtone.osc))

; A setup to create partial messages for renoise.
;

; ((note-on ...) midi-note midi-val)
(def note-on
  [renoise-client instrument-id track-id]
  (partial osc-send renoise-client "/renoise/trigger/note_on" instrument-id track-id))

; ((note-off ...) midi-note)
(def note-off
  [renoise-client instrument-id track-id]
  (partial osc-send renoise-client "/renoise/trigger/note_off" instrument-id track-id))
