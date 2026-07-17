import { useEffect, useState } from 'react';
import { BriefcaseBusiness, GraduationCap, Sparkles, TrendingUp } from 'lucide-react';
import Sidebar from '../../components/Sidebar/Sidebar';
import TopNavbar from '../../components/TopNavbar/TopNavbar';
import DashboardCard from '../../components/DashboardCard/DashboardCard';
import ProfileCard from '../../components/ProfileCard/ProfileCard';
import QuickActionCard from '../../components/QuickActionCard/QuickActionCard';
import { fetchDashboardData } from '../../services/api';
import styles from './StudentDashboard.module.css';

function StudentDashboard() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadData = async () => {
      try {
        const response = await fetchDashboardData();
        setData(response);
      } catch (error) {
        console.error('Error loading dashboard data', error);
      } finally {
        setLoading(false);
      }
    };

    loadData();
  }, []);

  return (
    <div className={styles.shell}>
      <Sidebar />

      <main className={styles.mainContent}>
        <TopNavbar studentName={data?.profile?.name?.split(' ')[0] || 'Aarav'} />

        <section className={styles.heroSection}>
          <div className={styles.heroInfo}>
            <p className={styles.eyebrow}>Placement pulse</p>
            <h2>Stay ahead of every opportunity</h2>
            <p>
              Track applications, resume readiness, and recruiter activity in one focused view.
            </p>
            <button className={styles.primaryButton}>Explore drives</button>
          </div>
          <div className={styles.heroHighlight}>
            <Sparkles size={24} />
            <div>
              <strong>{loading ? 'Loading insights...' : data?.insight?.title}</strong>
              <p>{loading ? 'Preparing your AI placement summary.' : data?.insight?.body}</p>
            </div>
          </div>
        </section>

        <section className={styles.statsGrid}>
          <DashboardCard
            title="Applications"
            value="24"
            subtitle="4 shortlisted"
            accent="#2563eb"
            icon={BriefcaseBusiness}
          />
          <DashboardCard
            title="CGPA"
            value="8.9"
            subtitle="Top 10% of cohort"
            accent="#7c3aed"
            icon={GraduationCap}
          />
          <DashboardCard
            title="Skill score"
            value="91%"
            subtitle="+12% this month"
            accent="#0f766e"
            icon={TrendingUp}
          />
        </section>

        <section className={styles.contentGrid}>
          <ProfileCard />
          <div className={styles.quickActions}>
            <QuickActionCard title="Resume AI Review" description="Refine your resume for targeted companies" badge="AI" />
            <QuickActionCard title="Upload certificates" description="Add new achievements to your profile" badge="FILE" />
          </div>
        </section>
      </main>
    </div>
  );
}

export default StudentDashboard;
