import React, { useEffect, useState } from "react";
import Rainfall from "react-rainfall-animation/src/Rain";
import Lottie from "react-lottie";
import animationData from "../lotties/sparkle-animation.json";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import NavigationBar from "../components/NavigationBar";

export default function RateView() {
  const defaultValue = 50;
  const [rating, setRating] = useState(defaultValue);
  const [question, setQuestion] = useState();
  const [note, setNote] = useState("");

  let navigate = useNavigate();

  const { questionId } = useParams();

  useEffect(() => {
    getQuestionData();
  }, []);

  const getQuestionData = async () => {
    const response = await fetch(`/questions/${questionId}`).then((response) =>
      response.json()
    );

    setQuestion(response);
  };

  const sparklesOptions = {
    loop: false,
    autoplay: true,
    animationData: animationData,
    rendererSettings: {
      preserveAspectRatio: "xMidYMid slice",
    },
  };

  if (question) {
    return (
      <div
        className={`h-screen w-screen bg-gradient-to-b ${getWeatherGradient(
          rating
        )}`}
      >
        {rating === 0 && <Rainfall dropletsAmount={200}></Rainfall>}

        <div className="container mx-auto px-20 text-white z-10 py-10">
          <p className="text-3xl mb-5 text-center">{question["question"]}</p>
          <div className={`flex gap-5 items-center mb-10 h-10`}>
            <span
              className={`text-${getEmojiSizeNegative(rating)}xl w-32 z-10`}
            >
              🌩
            </span>

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

            <span className={`text-${getEmojiSize(rating)}xl w-32 z-10`}>
              ☀️
            </span>
          </div>
          <p className="mb-5 text-xl text-center">
            Möchtest du noch etwas anmerken?
          </p>
          <input
            type="text"
            onChange={(e) => setNote(e.target.value)}
            className="input input-bordered w-full mb-10 glass text-white"
          />

          {/* Todo: Post request implementation */}
          <div className="flex justify-center">
            <button
              onClick={() => postAnswer()}
              className="btn btn-primary glass"
            >
              Submit
            </button>
          </div>

          <div className="bottom-0 mt-50">
            {rating === 100 && (
              <Lottie options={sparklesOptions} width={600} height={600} />
            )}
          </div>
        </div>
      </div>
    );
  } else {
    return <></>;
  }

  function getEmojiSize(sliderValue: number) {
    if (sliderValue === 0) {
      return 1;
    } else if (sliderValue === 25) {
      return 3;
    } else if (sliderValue === 50) {
      return 5;
    } else if (sliderValue === 75) {
      return 7;
    } else {
      return 8;
    }
  }

  function getEmojiSizeNegative(sliderValue: number) {
    if (sliderValue === 0) {
      return 8;
    } else if (sliderValue === 25) {
      return 7;
    } else if (sliderValue === 50) {
      return 5;
    } else if (sliderValue === 75) {
      return 3;
    } else {
      return 1;
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

  function postAnswer() {
    console.log("Answer", rating / 25 + 1);

    if (question) {
      fetch(`/answer/${question["id"]}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        // mode: "cors",
        body: JSON.stringify({
          value: rating / 25 + 1,
          note: note,
          date: Date.now(),
        }),
      }).then(() => navigate("/"));
    }
  }
}
