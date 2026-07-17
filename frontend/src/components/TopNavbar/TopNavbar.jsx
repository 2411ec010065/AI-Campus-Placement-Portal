import { Bell, Search, Settings } from 'lucide-react';
import styles from './TopNavbar.module.css';

function TopNavbar({ studentName }) {
  return (
    <header className={styles.topbar}>
      <div className={styles.titleBlock}>
        <p className={styles.eyebrow}>Student dashboard</p>
        <h1>Welcome back, {studentName}</h1>
      </div>

      <div className={styles.actions}>
        <label className={styles.searchBox}>
          <Search size={18} />
          <input type="text" placeholder="Search companies or jobs" />
        </label>
        <button className={styles.iconButton} aria-label="Settings">
          <Settings size={18} />
        </button>
        <button className={styles.iconButton} aria-label="Notifications">
          <Bell size={18} />
        </button>
      </div>
    </header>
  );
}

export default TopNavbar;
