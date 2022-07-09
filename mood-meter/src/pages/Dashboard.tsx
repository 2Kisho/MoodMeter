import NavigationBar from "../components/NavigationBar";
import { Link } from "react-router-dom";
import MoodDiagram from "./TestDiagram";
import { useEffect, useState } from "react";
import Lottie from "react-lottie";
import animationData from "../lotties/pig-animation.json";

export default function DashboardView() {
  const [questions, setQuestions] = useState();

  useEffect(() => {
    getQuestionsData();
  }, []);

  const getQuestionsData = async () => {
    const response = await fetch("/questions").then((response) =>
      response.json()
    );
    setQuestions(response);
  };

  const pigOptions = {
    loop: true,
    autoplay: true,
    animationData: animationData,
    rendererSettings: {
      preserveAspectRatio: "xMidYMid slice",
    },
  };

  if (questions) {
    const latestAnswerIndex = Object.keys(questions[0]["answers"]).length - 1;
    const latestAnswerDate = new Date(
      questions[0]["answers"][latestAnswerIndex]["date"]
    );
    const todayDate = new Date();
    const todayWasAnswered =
      latestAnswerDate.getDate() === todayDate.getDate() &&
      latestAnswerDate.getMonth() === todayDate.getMonth() &&
      latestAnswerDate.getFullYear() === todayDate.getFullYear();

    return (
      <NavigationBar>
        <div className="flex justify-center">
          <MoodDiagram width={500} height={500} question={questions[0]} />
        </div>

        <div className="flex justify-center items-center">
          <button
            className={`btn btn-primary ${todayWasAnswered && "btn-disabled"}`}
          >
            <Link to={`rate/${questions[0]["id"]}`}>Eintrag erstellen</Link>
          </button>
          {!todayWasAnswered && (
            <span className="w-16 mb-4">
              <Lottie options={pigOptions} width={100} height={100} />
            </span>
          )}
        </div>
      </NavigationBar>
    );
  } else {
    return <></>;
  }
}
