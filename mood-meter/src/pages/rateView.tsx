import React, { useState } from "react";

export type RateViewProps = {
  question: string;
};

export default function RateView(props: RateViewProps) {
  const defaultValue = "50";
  const [rating, setRating] = useState(defaultValue);

  return (
    <>
      <p className="text-2xl mb-5">{props.question}</p>

      <input
        type="range"
        min="0"
        max="100"
        defaultValue={defaultValue}
        className="range range-primary range-lg mb-10"
        step="25"
        onChange={(element) => setRating(element.target.value)}
      />

      <p className="mb-5">Möchtest du noch etwas anmerken?</p>

      <input
        type="text"
        placeholder="Notiere etwas..."
        className="input input-bordered w-full mb-10"
      />

      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </>
  );
}
