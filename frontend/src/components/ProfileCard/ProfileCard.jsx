import { GraduationCap, Mail, MapPin, Phone } from 'lucide-react';
import styles from './ProfileCard.module.css';

function ProfileCard() {
  return (
    <section className={styles.profileCard}>
      <div className={styles.profileHeader}>
        <div className={styles.avatar}>AK</div>
        <div>
          <h3>Aarav Kumar</h3>
          <p>B.Tech Computer Science • 2026</p>
        </div>
      </div>

      <div className={styles.details}>
        <div>
          <GraduationCap size={16} />
          <span>AI & Data Science Specialization</span>
        </div>
        <div>
          <Mail size={16} />
          <span>aarav.kumar@campus.ai</span>
        </div>
        <div>
          <Phone size={16} />
          <span>+91 98765 43210</span>
        </div>
        <div>
          <MapPin size={16} />
          <span>Hyderabad, India</span>
        </div>
      </div>
    </section>
  );
}

export default ProfileCard;
