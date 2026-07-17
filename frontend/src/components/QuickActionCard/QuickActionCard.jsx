import { ArrowRight, FileText, Sparkles } from 'lucide-react';
import styles from './QuickActionCard.module.css';

function QuickActionCard({ title, description, badge }) {
  return (
    <article className={styles.card}>
      <div className={styles.iconWrap}>
        {badge === 'AI' ? <Sparkles size={18} /> : <FileText size={18} />}
      </div>
      <div className={styles.body}>
        <h4>{title}</h4>
        <p>{description}</p>
      </div>
      <button className={styles.actionButton}>
        <ArrowRight size={16} />
      </button>
    </article>
  );
}

export default QuickActionCard;
