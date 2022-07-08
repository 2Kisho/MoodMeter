import Layout from "../components/layout";
import { Link } from "react-router-dom";
import TestDiagram from "./TestDiagram";
import { useEffect, useState } from "react";

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

  if (questions) {
    return (
      <Layout>
        <TestDiagram width={500} height={500} />

        <button className="btn btn-primary">
          <Link to={`rate/${questions[0]["id"]}`}>Bewerten</Link>
        </button>
      </Layout>
    );
  } else {
    return <></>;
  }
}
