import { Line, LineChart, Tooltip, XAxis, YAxis } from "recharts";

export type CurveProps = {
  width: number;
  height: number;
  question: any;
};

export default function MoodDiagram({ width, height, question }: CurveProps) {
  for (let index = 0; index < question["answers"].length; index++) {
    const date = new Date(question["answers"][index]["date"]);

    question["answers"][index]["weekday"] = date.toLocaleDateString("de-DE", {
      weekday: "short",
    });
  }

  return (
    <div className="flex flex-col items-center">
      <LineChart
        width={300}
        height={300}
        data={question["answers"]}
        margin={{ top: 5, bottom: 5 }}
        className="my-5"
      >
        <XAxis dataKey="weekday" />
        <YAxis domain={[0, 5]} />
        <Tooltip />
        <Line type="monotone" dataKey="value" stroke="#ff7300" yAxisId={0} />
      </LineChart>

      <span>{question["title"]}</span>
    </div>
  );
}
