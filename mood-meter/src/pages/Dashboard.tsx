import Layout from "../components/layout";
import { Link } from "react-router-dom";
import TestDiagram from "./TestDiagram";

export default function DashboardView() {
  const testQuestionId = "123";
  return (
    <Layout>
      <TestDiagram width={500} height={500} />

      <button className="btn btn-primary">
        <Link to={`rate/${testQuestionId}`}>Bewerten</Link>
      </button>
    </Layout>
  );
}
