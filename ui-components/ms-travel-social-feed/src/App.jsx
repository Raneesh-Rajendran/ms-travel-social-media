import Hero from "./components/Hero.jsx";
import FeatureGrid from "./components/FeatureGrid.jsx";
import PrimaryAction from "./components/PrimaryAction.jsx";

const features = [
  {
    title: "Share your journeys",
    description: "Post stories, photos, and tips with your travel community."
  },
  {
    title: "Curate itineraries",
    description: "Organize every stop with easy-to-scan day plans."
  },
  {
    title: "Connect locally",
    description: "Discover experiences recommended by travelers nearby."
  }
];

export default function App() {
  return (
    <div className="page">
      <Hero />
      <section className="content">
        <FeatureGrid features={features} />
        <PrimaryAction />
      </section>
    </div>
  );
}
