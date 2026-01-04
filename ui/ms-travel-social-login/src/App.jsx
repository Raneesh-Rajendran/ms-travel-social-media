const benefits = [
  "Save trips across devices",
  "Discover curated itineraries",
  "Connect with fellow travelers"
];

export default function App() {
  return (
    <div className="app">
      <main className="card">
        <header className="card__header">
          <p className="eyebrow">MS Travel Social</p>
          <h1>Welcome back</h1>
          <p className="subtitle">
            Sign in to manage your travel feed, itineraries, and saved places.
          </p>
        </header>

        <form className="form">
          <label className="field">
            <span>Email address</span>
            <input type="email" placeholder="you@example.com" required />
          </label>

          <label className="field">
            <span>Password</span>
            <input type="password" placeholder="••••••••" required />
          </label>

          <div className="form__row">
            <label className="checkbox">
              <input type="checkbox" />
              Remember me
            </label>
            <button type="button" className="link">
              Forgot password?
            </button>
          </div>

          <button type="submit" className="primary">
            Sign in
          </button>

          <button type="button" className="secondary">
            Continue with Google
          </button>
        </form>
      </main>

      <aside className="panel">
        <div>
          <h2>Plan your next adventure</h2>
          <p>
            Keep everything organized in one place so you can focus on the
            journey.
          </p>
          <ul>
            {benefits.map((benefit) => (
              <li key={benefit}>{benefit}</li>
            ))}
          </ul>
        </div>
        <footer className="panel__footer">
          <p>
            New here? <span>Create an account</span>
          </p>
        </footer>
      </aside>
    </div>
  );
}
