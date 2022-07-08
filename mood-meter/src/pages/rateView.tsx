import React, { useState } from "react";

export type RateViewProps = {
  question: string;
};

export default function RateView(props: RateViewProps) {
  const defaultValue = 50;
  const [rating, setRating] = useState(defaultValue);

  return (
    <div
      className={`h-screen w-screen bg-gradient-to-b ${getWeatherGradient(
        rating
      )}`}
    >
      <div className="container mx-auto px-20 text-white">
        <p className="text-2xl mb-5">{props.question}</p>

        <div className={`flex gap-5 items-center mb-10 h-10`}>
          <span className={`text-${getEmojiSizeNegative(rating)}xl`}>🌩</span>
          <input
            type="range"
            min={0}
            max={100}
            defaultValue={defaultValue}
            className="range range-primary range-lg"
            step={25}
            onChange={(element) => {
              setRating(parseInt(element.target.value));
            }}
          />
          <span className={`text-${getEmojiSize(rating)}xl`}>☀️</span>
        </div>

        <p className="mb-5">Möchtest du noch etwas anmerken?</p>

        <input
          type="text"
          className="input input-bordered w-full mb-10 glass text-white"
        />

        <button type="submit" className="btn btn-primary glass">
          Submit
        </button>
      </div>
    </div>
  );

  function getEmojiSize(sliderValue: number) {
    if (sliderValue === 0) {
      return "";
    } else if (sliderValue === 25) {
      return 2;
    } else if (sliderValue === 50) {
      return 4;
    } else if (sliderValue === 75) {
      return 6;
    } else {
      return 8;
    }
  }

  function getEmojiSizeNegative(sliderValue: number) {
    if (sliderValue === 0) {
      return 8;
    } else if (sliderValue === 25) {
      return 6;
    } else if (sliderValue === 50) {
      return 4;
    } else if (sliderValue === 75) {
      return 2;
    } else {
      return "";
    }
  }

  function getWeatherGradient(sliderValue: number) {
    if (sliderValue === 0) {
      return "to-[#6a90c1] from-[#020344]";
    } else if (sliderValue === 25) {
      return "to-[#9bafd9] from-[#103783]";
    } else if (sliderValue === 50) {
      return "to-[#ABDCFF] from-[#0396FF]";
    } else if (sliderValue === 75) {
      return "to-[#f9df59] from-[#cf79e0]";
    } else {
      return "to-[#ffed00] from-[#f7a2a1]";
    }
  }
}
