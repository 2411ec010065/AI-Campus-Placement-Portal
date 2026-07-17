import styles from './DashboardCard.module.css';

function DashboardCard({ title, value, subtitle, accent, icon: Icon }) {
  return (
    <article className={styles.card} style={{ '--accent': accent }}>
      <div className={styles.iconWrap}>
        {Icon ? <Icon size={18} /> : null}
      </div>
      <div>
        <p className={styles.title}>{title}</p>
        <h3>{value}</h3>
        <span>{subtitle}</span>
      </div>
    </article>
  );
}

export default DashboardCard;
