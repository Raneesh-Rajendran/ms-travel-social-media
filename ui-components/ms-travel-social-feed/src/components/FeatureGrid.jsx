export default function FeatureGrid({ features }) {
  return (
    <section className="feature-grid">
      {features.map((feature) => (
        <article className="feature-card" key={feature.title}>
          <h3>{feature.title}</h3>
          <p>{feature.description}</p>
        </article>
      ))}
    </section>
  );
}
