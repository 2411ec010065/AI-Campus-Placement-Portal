import { BookOpen, BriefcaseBusiness, CalendarDays, LayoutDashboard, MessageSquare, Sparkles, Users } from 'lucide-react';
import styles from './Sidebar.module.css';

const navItems = [
  { label: 'Overview', icon: LayoutDashboard, active: true },
  { label: 'Applications', icon: BriefcaseBusiness },
  { label: 'Learning', icon: BookOpen },
  { label: 'Schedule', icon: CalendarDays },
  { label: 'Mentors', icon: Users },
  { label: 'Messages', icon: MessageSquare },
];

function Sidebar() {
  return (
    <aside className={styles.sidebar}>
      <div className={styles.brand}>
        <div className={styles.brandIcon}>
          <Sparkles size={20} />
        </div>
        <div>
          <h2>AI Campus</h2>
          <p>Placement Portal</p>
        </div>
      </div>

      <nav className={styles.nav} aria-label="Sidebar">
        {navItems.map(({ label, icon: Icon, active }) => (
          <button key={label} className={`${styles.navItem} ${active ? styles.active : ''}`}>
            <Icon size={18} />
            <span>{label}</span>
          </button>
        ))}
      </nav>

      <div className={styles.supportBox}>
        <p>Placement readiness</p>
        <strong>92% complete</strong>
        <span>Keep your profile updated for top-tier companies.</span>
      </div>
    </aside>
  );
}

export default Sidebar;
